//
//  Empresa.h
//  Dignificame
//
//  Created by Rafa Prats on 23/03/14.
//  Copyright (c) 2014 Rafa Prats. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Empresa : NSObject

@property (weak, nonatomic) NSString *nombre;
@property (weak, nonatomic) NSString *lat;
@property (weak, nonatomic) NSString *lng;
@property (weak, nonatomic) NSString *descripcion;
@property (weak, nonatomic) NSString *ciudad;

- (id)initWithJSONDictionary:(NSDictionary *)jsonDictionary;

@end
