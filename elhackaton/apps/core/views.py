from django.shortcuts import render, get_object_or_404

from .models import Oferta
from .forms import NuevaDenunciaForm, BuscarOfertasForm


def index(request):
    ofertas = Oferta.objects.all()
    if request.method == 'POST':
        form = BuscarOfertasForm(request.POST)
        if form.is_valid():
            ofertas = Oferta.objects.filter(empresa__ciudad=form.cleaned_data['ciudad']).filter(categoria=form.cleaned_data['categoria'])
    form = BuscarOfertasForm()
    return render(request, 'core/index.html',
        {'ofertas': ofertas, 'form': form})


def oferta(request, id_oferta):
    oferta = get_object_or_404(Oferta, id=id_oferta)
    if request.method == 'POST':
        form = NuevaDenunciaForm(request.POST)
        if form.is_valid():
            denuncia = form.save(commit=False)
            denuncia.oferta = oferta
            denuncia.empresa = oferta.empresa
            denuncia.save()
    form = NuevaDenunciaForm()
    return render(request, 'core/oferta.html',
        {'oferta': oferta, 'form': form})