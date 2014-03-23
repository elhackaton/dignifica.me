# -*- coding: utf-8 -*-
from django import forms

from .models import Denuncia, Oferta


class NuevaDenunciaForm(forms.ModelForm):
    class Meta:
        model = Denuncia
        fields = ('motivo', 'comentario')


class BuscarOfertasForm(forms.Form):
    ciudad = forms.CharField()
    categoria = forms.ChoiceField(choices=Oferta.CATEGORIA_CHOICES)
