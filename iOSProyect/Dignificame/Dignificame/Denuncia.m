//
//  Denuncia.m
//  Dignificame
//
//  Created by Rafa Prats on 23/03/14.
//  Copyright (c) 2014 Rafa Prats. All rights reserved.
//

#import "Denuncia.h"

@implementation Denuncia

- (id)initWithJSONDictionary:(NSDictionary *)jsonDictionary {
    if(self = [self init]) {
        // Assign all properties with keyed values from the dictionary
        _motivo = [jsonDictionary objectForKey:@"motivo"];
        _comentario = [jsonDictionary objectForKey:@"comentario"];
    }
    
    return self;
}

@end
