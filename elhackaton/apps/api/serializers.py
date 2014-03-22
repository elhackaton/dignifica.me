from rest_framework import serializers

from apps.core.models import Oferta, Empresa, Denuncia


class EmpresaSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Empresa


class DenunciaSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Denuncia


class OfertaSerializer(serializers.HyperlinkedModelSerializer):
    denuncias = DenunciaSerializer(many=True)
    empresa = EmpresaSerializer(many=False)

    class Meta:
        model = Oferta
        fields = ('id', 'titulo', 'categoria', 'descripcion', 'requisitos',
            'url', 'denuncias', 'empresa')
