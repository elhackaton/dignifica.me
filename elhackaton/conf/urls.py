from django.conf import settings
from django.conf.urls import patterns, include, url
from django.contrib import admin

from rest_framework import routers
from apps.api import views


admin.autodiscover()


router = routers.DefaultRouter()
router.register(r'ofertas', views.OfertaViewSet)
router.register(r'empresas', views.EmpresaViewSet)
router.register(r'denuncias', views.DenunciaViewSet)


urlpatterns = patterns('',
    # Uncomment the admin/doc line below to enable admin documentation:
    # url(r'^admin/doc/', include('django.contrib.admindocs.urls')),
    url(r'^api-auth/', include('rest_framework.urls', namespace='rest_framework')),
    url(r'^api/', include(router.urls)),
    url(r'^admin-django/', include(admin.site.urls)),
    url(r'', include('apps.core.urls', namespace='core')),
)


if settings.DEBUG:
    # handle static files on development
    from django.contrib.staticfiles.urls import staticfiles_urlpatterns
    urlpatterns += staticfiles_urlpatterns()

    # handle user uploaded files on development
    from django.conf.urls.static import static
    urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)