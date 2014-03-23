//
//  Empresa.m
//  Dignificame
//
//  Created by Rafa Prats on 23/03/14.
//  Copyright (c) 2014 Rafa Prats. All rights reserved.
//

#import "Empresa.h"

@implementation Empresa

- (id)initWithJSONDictionary:(NSDictionary *)jsonDictionary {
    if(self = [self init]) {
        // Assign all properties with keyed values from the dictionary
        _nombre = [jsonDictionary objectForKey:@"nombre"];
        _lat = [jsonDictionary objectForKey:@"lat"];
        _lng = [jsonDictionary objectForKey:@"lng"];
        _descripcion = [jsonDictionary objectForKey:@"descripcion"];
        _ciudad = [jsonDictionary objectForKey:@"ciudad"];

    }
    
    return self;
}

@end
