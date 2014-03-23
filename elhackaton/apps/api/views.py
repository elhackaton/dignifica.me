from django.shortcuts import get_object_or_404
from django.db.models import Count
from django.http import HttpResponse

from rest_framework import viewsets
from rest_framework.response import Response

from apps.core.models import Oferta, Empresa, Denuncia

from .serializers import OfertaSerializer, EmpresaSerializer, DenunciaSerializer
from .forms import NuevaDenunciaForm


class EmpresaViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows Empresa to be viewed or edited.
    """
    queryset = Empresa.objects.all()
    serializer_class = EmpresaSerializer

    def list(self, request):
        queryset = Empresa.objects.all()
        serializer = EmpresaSerializer(queryset, many=True)
        return Response(serializer.data)

    def retrieve(self, request, pk=None):
        queryset = Empresa.objects.all()
        empresa = get_object_or_404(queryset, pk=pk)
        serializer = EmpresaSerializer(empresa)
        return Response(serializer.data)


class OfertaViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows Oferta to be viewed or edited.
    """
    queryset = Oferta.objects.all()
    serializer_class = OfertaSerializer
    
    def list(self, request):
        categoria = request.GET.get('categoria')
        ciudad = request.GET.get('ciudad')
        order_by_denuncias = request.GET.get('ordered')
        queryset = self.queryset
        if ciudad:
            queryset = queryset.filter(empresa__ciudad=ciudad)
        if categoria:
            queryset = queryset.filter(categoria=categoria)
        if order_by_denuncias:
            queryset = queryset.annotate(num_denuncias=Count('denuncias')).order_by('-num_denuncias')
        serializer = OfertaSerializer(queryset, many=True)
        return Response(serializer.data)

    def retrieve(self, request, pk=None):
        queryset = Oferta.objects.all()
        oferta = get_object_or_404(queryset, pk=pk)
        serializer = OfertaSerializer(oferta)
        return Response(serializer.data)


class DenunciaViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows Denuncia to be viewed or edited.
    """
    queryset = Denuncia.objects.all()
    serializer_class = DenunciaSerializer

    def list(self, request):
        queryset = Denuncia.objects.all()
        serializer = DenunciaSerializer(queryset, many=True)
        return Response(serializer.data)

    def retrieve(self, request, pk=None):
        queryset = Denuncia.objects.all()
        denuncia = get_object_or_404(queryset, pk=pk)
        serializer = DenunciaSerializer(denuncia)
        return Response(serializer.data)

    def create(self, request, *args, **kwargs):
        oferta = get_object_or_404(Oferta, id=request.DATA.get('id_oferta'))
        denuncia = Denuncia()
        denuncia.oferta = oferta
        denuncia.empresa = oferta.empresa
        denuncia.motivos = request.DATA.get('motivos')
        denuncia.comentario = request.DATA.get('comentario') if request.DATA.get('comentario') else ''
        denuncia.save()
        return HttpResponse()
