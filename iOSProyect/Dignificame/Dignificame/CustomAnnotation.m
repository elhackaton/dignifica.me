#import "CustomAnnotation.h"

@implementation CustomAnnotation
// Hacemos synthesize
@synthesize title, subtitle, coordinate;

// Implementamos el método de inicialización del objeto.
- (id)initWithTitle:(NSString *)aTitle subtitle:(NSString*)aSubtitle andCoordinate:(CLLocationCoordinate2D)coord
{
	self = [super init];
	title = aTitle;
    subtitle = aSubtitle;
	coordinate = coord;
	return self;
}

@end