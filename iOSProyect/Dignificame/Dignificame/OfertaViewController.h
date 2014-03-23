//
//  OfertaViewController.h
//  Dignificame
//
//  Created by Rafa Prats on 23/03/14.
//  Copyright (c) 2014 Rafa Prats. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Oferta.h"
#import <MapKit/MapKit.h>


@interface OfertaViewController : UIViewController

@property (weak, nonatomic) IBOutlet UILabel *tituloLbl;
@property (weak, nonatomic) IBOutlet UILabel *empresaLbl;
@property (weak, nonatomic) IBOutlet UITextView *requisitosTxt;
@property (weak, nonatomic) IBOutlet UITextView *experienciaTxt;
@property int indice;

@property(nonatomic, retain) IBOutlet MKMapView *mapView;

@end
