from django.contrib import admin

from .models import Empresa, Oferta, OfertaProvider, Denuncia


admin.site.register(Empresa)
admin.site.register(Oferta)
admin.site.register(OfertaProvider)
admin.site.register(Denuncia)
