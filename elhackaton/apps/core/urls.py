from django.conf.urls import patterns, url
from django.views.generic import TemplateView


urlpatterns = patterns(
    'apps.core.views',
    url(r'^$',
        TemplateView.as_view(template_name='layouts/base.html'),
        name='home'),
)