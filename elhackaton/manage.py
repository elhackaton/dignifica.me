#!/usr/bin/env python
import os
import sys

if __name__ == "__main__":
    os.environ.setdefault("DJANGO_SETTINGS_MODULE", "conf.settings")

    # django-configurations
    os.environ.setdefault("DJANGO_CONFIGURATION", "Production")
    from configurations import importer
    importer.install(check_options=True)

    from django.core.management import execute_from_command_line

    execute_from_command_line(sys.argv)