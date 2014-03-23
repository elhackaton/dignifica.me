from django.conf.urls import patterns, url


urlpatterns = patterns(
    'apps.core.views',
    url(r'^$', 'index',  name='index'),
    url(r'^oferta/(?P<id_oferta>\w+)/', 'oferta', name='oferta'),
)