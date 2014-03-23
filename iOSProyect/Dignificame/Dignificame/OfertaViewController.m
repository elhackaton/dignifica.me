//
//  OfertaViewController.m
//  Dignificame
//
//  Created by Rafa Prats on 23/03/14.
//  Copyright (c) 2014 Rafa Prats. All rights reserved.
//

#import "OfertaViewController.h"
#import "AppDelegate.h"
#import "CustomAnnotation.h"

@interface OfertaViewController ()

@end

@implementation OfertaViewController

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    // Creamos una coordenada inicial, en nuestro caso perteneciente a Valencia.
    CLLocationCoordinate2D initialLocation;
    initialLocation.latitude = 36.8415281;
    initialLocation.longitude= -2.4571166;
    
    // Esto situará el centro del mapa en Valencia con la distancia de región que establezcamos.
    MKCoordinateRegion region = MKCoordinateRegionMakeWithDistance(initialLocation, 2000, 2000);
    
    [self.mapView setRegion:region animated:YES];
    
    // Generaremos 10 anotaciones, o las que definamos en el for.
    for(int i = 0; i < 10; i++) {
        
        // Calculamos una distancia aleatoria en latitud y longitud suficientemente corta para que se muestre en nuestra región.
        CGFloat latDelta = rand()*.035/RAND_MAX -.02;
        CGFloat longDelta = rand()*.03/RAND_MAX -.015;
        
        CGFloat newLat = initialLocation.latitude + latDelta;
        CGFloat newLon = initialLocation.longitude + longDelta;
        
        CLLocationCoordinate2D newCoord = {newLat, newLon};
        
        // Creamos la anotación
        CustomAnnotation *annotation = [[CustomAnnotation alloc]initWithTitle: @"Captador media jornada ONG Almeria"
                                                                     subtitle: @"Comite Español de ACNUR"
                                                                andCoordinate:newCoord];
        // Y la insertamos en el mapa
        [self.mapView addAnnotation:annotation];
        
        
        
    }
}


- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
