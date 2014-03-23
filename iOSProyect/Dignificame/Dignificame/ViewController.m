//
//  ViewController.m
//  Dignificame
//
//  Created by Rafa Prats on 22/03/14.
//  Copyright (c) 2014 Rafa Prats. All rights reserved.
//

#import "ViewController.h"
#import "Oferta.h"
#import "Empresa.h"
#import "AppDelegate.h"

@interface ViewController ()


@end

@implementation ViewController

- (IBAction)buscar:(id)sender {
    [super didReceiveMemoryWarning];
    
    NSURL *url = [NSURL URLWithString:@"http://192.168.1.68:9000/api/ofertas/?format=json"];
    
    // Create a NSURLRequest with the given URL
    NSURLRequest *request = [NSURLRequest requestWithURL:url
                                             cachePolicy:NSURLRequestReloadIgnoringLocalAndRemoteCacheData
                                         timeoutInterval:30.0];
	
    // Get the data
    NSURLResponse *response;
	NSData *data = [NSURLConnection sendSynchronousRequest:request returningResponse:&response error:nil];
    NSError *e = nil;
    NSArray *jsonArray = [NSJSONSerialization JSONObjectWithData: data options: NSJSONReadingMutableContainers error: &e];
    
    if (!jsonArray) {
        NSLog(@"Error parsing JSON: %@", e);
    } else {
        AppDelegate *appDelegate = (AppDelegate *)[[UIApplication sharedApplication] delegate];
        [appDelegate setOfertas:[[NSMutableArray alloc] init]];

        for(NSDictionary *item in jsonArray) {
            //NSLog(@"Item: %@", [item objectForKey:@"titulo"]);
            Oferta *oferta = [[Oferta alloc] initWithJSONDictionary:item];
            Empresa *empresa = [[Empresa alloc] initWithJSONDictionary:[item objectForKey:@"empresa"]];
            
            NSMutableArray *denuncias = [[NSMutableArray alloc] init];
            
            NSMutableArray *lol = [item valueForKey:@"denuncias"];

            for (int i=0; i<lol.count; i++) {
                Denuncia *denuncia = [[Denuncia alloc] initWithJSONDictionary:[lol objectAtIndex:i]];
                [denuncias addObject:denuncia];
            }
            

            [oferta setEmpresa:empresa];
            [oferta setDenuncias:denuncias];
            [[appDelegate ofertas] addObject:oferta];
            
        }
    }

    
    [self performSegueWithIdentifier:@"buscar" sender:self];
}

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void) viewWillAppear:(BOOL)animated
{
	[super viewWillAppear:animated];
    
    [self.navigationController setNavigationBarHidden:YES];

}


- (void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event {
    [self.view endEditing:YES];
}

@end
