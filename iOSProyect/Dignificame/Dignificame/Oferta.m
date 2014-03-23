//
//  Oferta.m
//  Dignificame
//
//  Created by Rafa Prats on 23/03/14.
//  Copyright (c) 2014 Rafa Prats. All rights reserved.
//

#import "Oferta.h"

@implementation Oferta

// Init the object with information from a dictionary
- (id)initWithJSONDictionary:(NSDictionary *)jsonDictionary {
    if(self = [self init]) {
        // Assign all properties with keyed values from the dictionary
        _titulo = [jsonDictionary objectForKey:@"titulo"];
        _descripcion = [jsonDictionary objectForKey:@"descripcion"];
        _requisitos = [jsonDictionary objectForKey:@"requisitos"];
        _url = [jsonDictionary objectForKey:@"url"];
    }
    
    return self;
}

@end
