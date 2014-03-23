//
//  TableViewController.m
//  Dignificame
//
//  Created by Rafa Prats on 22/03/14.
//  Copyright (c) 2014 Rafa Prats. All rights reserved.
//

#import "TableViewController.h"
#import "AppDelegate.h"
#import "Oferta.h"
#import "OfertaViewController.h"

@interface TableViewController ()

@end

@implementation TableViewController

- (id)initWithStyle:(UITableViewStyle)style
{
    self = [super initWithStyle:style];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    // Uncomment the following line to preserve selection between presentations.
    // self.clearsSelectionOnViewWillAppear = NO;
    
    // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
    // self.navigationItem.rightBarButtonItem = self.editButtonItem;
}

- (void) viewWillAppear:(BOOL)animated
{
	[super viewWillAppear:animated];
    
    [self.navigationController setNavigationBarHidden:NO];
    AppDelegate *appDelegate = (AppDelegate *)[[UIApplication sharedApplication] delegate];
    
    //NSLog([NSString stringWithFormat:@"%d",[[appDelegate ofertas] count]]);


    
    self.navigationItem.backBarButtonItem.title = @"Nueva búsqueda";
    
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    // Return the number of sections.
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    // Return the number of rows in the section.
    AppDelegate *appDelegate = (AppDelegate *)[[UIApplication sharedApplication] delegate];
    return [[appDelegate ofertas] count];
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *CellIdentifier = @"Cell";
    
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    
    // Configure the cell...
    AppDelegate *appDelegate = (AppDelegate *)[[UIApplication sharedApplication] delegate];
/*    for(Oferta *oferta in [appDelegate ofertas]) {
        //NSLog(@"%@",[st myMethodDefined]);
        cell.textLabel.text = @"asd";//[oferta titulo];
    }*/
    
    NSString *titulo = [[[appDelegate ofertas] objectAtIndex:indexPath.row] titulo];
    NSString *subtitulo = [[[[appDelegate ofertas] objectAtIndex:indexPath.row] empresa] nombre];

    cell.textLabel.text = titulo;
    cell.detailTextLabel.text = subtitulo;
    return cell;
}



#pragma mark - Navigation
- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    //[self setIndexPathSelected: indexPath.row];
    [self performSegueWithIdentifier:@"verOferta" sender:self];
    
}
/*
// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}


// This will get called too before the view appears
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    if ([[segue identifier] isEqualToString:@"verOferta"]) {
        OfertaViewController *vc = [segue destinationViewController];
        [vc setIndice: self.indexPathSelected];
    }
}
*/
@end
