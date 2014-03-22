import os

from configurations import Configuration, values


# Build paths inside the project like this: os.path.join(BASE_DIR, ...)
BASE_DIR = os.path.dirname(os.path.dirname(__file__))


class Common(Configuration):
    DJANGO_APPS = (
        'django.contrib.auth',
        'django.contrib.contenttypes',
        'django.contrib.sessions',
        'django.contrib.messages',
        'django.contrib.staticfiles',
        # 'django.contrib.sites',
        # Useful template tags
        # 'django.contrib.humanize',
        # Admin
        'django.contrib.admin',
        # Uncomment the next line to enable admin documentation:
        # 'django.contrib.admindocs',
    )

    THIRD_PARTY_APPS = (
        #'south',
    )

    LOCAL_APPS = (
        'apps.core',
    )

    INSTALLED_APPS = DJANGO_APPS + THIRD_PARTY_APPS + LOCAL_APPS

    MIDDLEWARE_CLASSES = (
        'django.contrib.sessions.middleware.SessionMiddleware',
        'django.middleware.common.CommonMiddleware',
        'django.middleware.csrf.CsrfViewMiddleware',
        'django.contrib.auth.middleware.AuthenticationMiddleware',
        'django.contrib.messages.middleware.MessageMiddleware',
        'django.middleware.clickjacking.XFrameOptionsMiddleware',
    )

    TEMPLATE_CONTEXT_PROCESSORS = Configuration.TEMPLATE_CONTEXT_PROCESSORS + (
        'django.core.context_processors.request',
    )

    ADMINS = (
        ('Javi Imbernon', 'javi@javimb.com'),
    )
    MANAGERS = ADMINS

    SITE_ID = 1
    ROOT_URLCONF = 'conf.urls'
    WSGI_APPLICATION = 'conf.wsgi.application'
    SECRET_KEY = 'not-so-secret'

    TIME_ZONE = 'Europe/Madrid'
    LANGUAGE_CODE = 'es-ES'

    USE_I18N = True
    USE_L10N = True
    USE_TZ = True

    FIXTURE_DIRS = (
        os.path.join(BASE_DIR, 'fixtures'),
    )

    TEMPLATE_DIRS = (
        os.path.join(BASE_DIR, 'templates_common'),
    )

    MEDIA_URL = '/media/'
    STATIC_URL = '/static/'

    SESSION_SERIALIZER = 'django.contrib.sessions.serializers.JSONSerializer'

    # A sample logging configuration. The only tangible logging
    # performed by this configuration is to send an email to
    # the site admins on every HTTP 500 error when DEBUG=False.
    # See http://docs.djangoproject.com/en/dev/topics/logging for
    # more details on how to customize your logging configuration.
    LOGGING = {
        'version': 1,
        'disable_existing_loggers': False,
        'filters': {
            'require_debug_false': {
                '()': 'django.utils.log.RequireDebugFalse'
            }
        },
        'handlers': {
            'mail_admins': {
                'level': 'ERROR',
                'filters': ['require_debug_false'],
                'class': 'django.utils.log.AdminEmailHandler'
            }
        },
        'loggers': {
            'django.request': {
                'handlers': ['mail_admins'],
                'level': 'ERROR',
                'propagate': True,
            },
        }
    }


class Local(Common):
    DEBUG = True
    TEMPLATE_DEBUG = DEBUG

    # INSTALLED_APPS = Common.INSTALLED_APPS + ('debug_toolbar',)

    DATABASES = values.DatabaseURLValue(
        'postgres://postgres:password@localhost/elhackaton')

    MEDIA_ROOT = os.path.join(BASE_DIR, 'media')

    STATICFILES_DIRS = (
        os.path.join(BASE_DIR, 'static'),
    )

    # MIDDLEWARE_CLASSES = Common.MIDDLEWARE_CLASSES + (
    #     'debug_toolbar.middleware.DebugToolbarMiddleware',
    # )

    # INTERNAL_IPS = ('127.0.0.1',)

    # DEBUG_TOOLBAR_CONFIG = {
    #     'INTERCEPT_REDIRECTS': False,
    #     'SHOW_TEMPLATE_CONTEXT': True,
    # }

    EMAIL_BACKEND = 'django.core.mail.backends.console.EmailBackend'


class Production(Common):
    DEBUG = False
    TEMPLATE_DEBUG = DEBUG

    SECRET_KEY = values.SecretValue()

    INSTALLED_APPS = Common.INSTALLED_APPS + (
        #'s3_folder_storage',
    )

    ALLOWED_HOSTS = ['*']

    # DATABASES = values.DatabaseURLValue(
    #     'postgres://postgres:password@localhost/elhackaton')

    # DEFAULT_FILE_STORAGE = 's3_folder_storage.s3.DefaultStorage'
    # DEFAULT_S3_PATH = "media"
    # STATICFILES_STORAGE = 's3_folder_storage.s3.StaticStorage'
    # STATIC_S3_PATH = "static"
    # AWS_ACCESS_KEY_ID = 'access_key_id'
    # AWS_SECRET_ACCESS_KEY = 'secret_access_key'
    # AWS_STORAGE_BUCKET_NAME = 'bucket_name'
    # AWS_QUERYSTRING_AUTH = False

    # MEDIA_ROOT = '/%s/' % DEFAULT_S3_PATH
    # MEDIA_URL = '//%s.s3.amazonaws.com/media/' % AWS_STORAGE_BUCKET_NAME
    # STATIC_ROOT = "/%s/" % STATIC_S3_PATH
    # STATIC_URL = '//%s.s3.amazonaws.com/static/' % AWS_STORAGE_BUCKET_NAME
    # ADMIN_MEDIA_PREFIX = STATIC_URL + 'admin/'

    STATICFILES_DIRS = (
        '/home/devtitude/webapps/static_elhackaton/',
    )
