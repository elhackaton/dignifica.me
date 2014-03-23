# -*- coding: utf-8 -*-
from django import forms

from apps.core.models import Denuncia


class NuevaDenunciaForm(forms.ModelForm):
    class Meta:
        model = Denuncia
