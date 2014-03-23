//
//  Oferta.h
//  Dignificame
//
//  Created by Rafa Prats on 23/03/14.
//  Copyright (c) 2014 Rafa Prats. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Empresa.h"
#import "Denuncia.h"

@interface Oferta : NSObject

@property (weak, nonatomic) NSString *titulo;
@property (weak, nonatomic) NSString *descripcion;
@property (weak, nonatomic) NSString *requisitos;
@property (weak, nonatomic) NSString *url;
@property Empresa *empresa;
@property NSMutableArray *denuncias;

- (id)initWithJSONDictionary:(NSDictionary *)jsonDictionary;

@end
