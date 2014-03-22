from django.db import models


class Empresa(models.Model):
    nombre = models.CharField(max_length=50)
    descripcion = models.TextField(blank=True)
    ciudad = models.CharField(max_length=50, blank=True)
    lat = models.FloatField(null=True, blank=True)
    lng = models.FloatField(null=True, blank=True)


class Oferta(models.Model):
    CATEGORIA_CHOICES = (
        ('Administracion Publica', 'Administracion Publica'),
        ('Atencion a clientes', 'Atencion a clientes'),
    )

    empresa = models.ForeignKey(Empresa, related_name='ofertas')
    titulo = models.CharField(max_length=250)
    categoria = models.CharField(choices=CATEGORIA_CHOICES, max_length=50)
    descripcion = models.TextField(blank=True)
    requisitos = models.TextField(blank=True)
    url = models.URLField(blank=True)


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
    MOTIVOS_CHOICES = (
        ('Motivo 1', 'Motivo 1'),
    )

    oferta = models.ForeignKey(Oferta, related_name='denuncias')
    empresa = models.ForeignKey(Empresa, related_name='denuncias')
    motivos = models.CharField(choices=MOTIVOS_CHOICES, max_length=200)
    comentario = models.TextField(blank=True)
