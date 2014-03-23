//
//  Denuncia.h
//  Dignificame
//
//  Created by Rafa Prats on 23/03/14.
//  Copyright (c) 2014 Rafa Prats. All rights reserved.
//

#import <Foundation/Foundation.h>


@interface Denuncia : NSObject

@property (weak, nonatomic) NSString *motivo;
@property (weak, nonatomic) NSString *comentario;

- (id)initWithJSONDictionary:(NSDictionary *)jsonDictionary;

@end
