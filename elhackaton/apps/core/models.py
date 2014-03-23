# -*- coding: utf-8 -*-
from geopy.geocoders import GoogleV3

from django.db import models


class Empresa(models.Model):
    nombre = models.CharField(max_length=50)
    descripcion = models.TextField(blank=True)
    ciudad = models.CharField(max_length=50, blank=True)
    lat = models.FloatField(null=True, blank=True)
    lng = models.FloatField(null=True, blank=True)
    codigo_postal = models.CharField(blank=True, max_length=50)
    ciudad = models.CharField(max_length=50)

    def __unicode__(self):
        return self.nombre

    def set_coordinates(self):
        self.lat, self.lng = GoogleV3().geocode('%s, %s' % (self.codigo_postal,
            self.ciudad))[1]
        self.save()


class Oferta(models.Model):
    CATEGORIA_CHOICES = (
        ('admon', 'Administracion Publica'),
        ('admon_empresas', 'Administracion de empresas'),
        ('atencion_clientes', 'Atencion a clientes'),
        ('idi', 'Calidad, produccion e I+D'),
        ('comercial', 'Comercial y ventas'),
        ('logistica', 'Logística y Almacén'),
        ('arte', 'Diseño y artes gráficas'),
        ('educacion', 'Educación y formación'),
        ('finanzas', 'Finanzas y banca'),
        ('informatica', 'Informática y telecomunicaciones'),
        ('ingenieria', 'Ingenieros y técnicos'),
        ('construccion', 'Inmobiliario y construcción'),
        ('legal', 'Legal'),
        ('marketing', 'Marketing y comunicación'),
        ('profesionales', 'Profesiones, artes y oficios'),
        ('recursos_humanos', 'Recursos humanos'),
        ('sanidad', 'Sanidad y salud'),
        ('turismo', 'Turismo y restauración'),
        ('ventas', 'Ventas al detalle'),
        ('otros', 'Otros'),
    )

    empresa = models.ForeignKey(Empresa, related_name='ofertas')
    titulo = models.CharField(max_length=250)
    categoria = models.CharField(choices=CATEGORIA_CHOICES, max_length=50)
    descripcion = models.TextField(blank=True)
    requisitos = models.TextField(blank=True)
    url = models.URLField(blank=True)

    def __unicode__(self):
        return self.titulo


class OfertaProvider(models.Model):
    PROVIDER_CHOICES = (
        ('infojobs', 'infojobs'),
    )

    oferta = models.ForeignKey(Oferta, related_name='providers')
    provider = models.CharField(choices=PROVIDER_CHOICES, max_length=50)
    uid = models.CharField(max_length=255)

    class Meta:
        unique_together = ('provider', 'uid')


class Denuncia(models.Model):
    MOTIVO_CHOICES = (
        ('Motivo 1', 'Motivo 1'),
    )

    oferta = models.ForeignKey(Oferta, related_name='denuncias')
    empresa = models.ForeignKey(Empresa, related_name='denuncias')
    motivo = models.CharField(choices=MOTIVO_CHOICES, max_length=200)
    comentario = models.TextField()
