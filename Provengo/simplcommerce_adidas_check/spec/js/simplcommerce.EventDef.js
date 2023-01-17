/* @Provengo summon selenium */

/**
 *  The LoginAdmin event defines the selenium actions for logging in admin to system.
 */
defineEvent(SeleniumSession, "LoginAdmin", function(session, e) {
  bp.log.info(e);
  session.writeText("//input[@id='Email']", e.username);
  session.writeText("//input[@id='Password']", e.password);
  session.click("//button[normalize-space()='Accept']");
  session.click("//button[normalize-space()='Log in']");
})

/**
 * The FindAdidasShirtAndDelete event defines the selenium action for deleting the shirt.
 */
defineEvent(SeleniumSession, "FindAdidasShirtAndDelete", function(session, e) {
  bp.log.info(e);
  session.click("//a[normalize-space()='Dashboard']"); //goes to dashboard where we can remove items
  session.click("//a[normalize-space()='Catalog']");
  session.click("//a[normalize-space()='Products']"); //go to products
  session.click("//span[@class='glyphicon glyphicon-remove'][1]") // remove first row in our case it will be the adidas shirt
  session.click("(//button[normalize-space()='OK'])[1]");
})

/**
 *  The LoginUser event defines the selenium actions for logging in user to system.
 */
defineEvent(SeleniumSession, "LoginUser", function(session, e) {
  bp.log.info(e);
  session.writeText("//input[@id='Email']", e.username);
  session.writeText("//input[@id='Password']", e.password);
  session.click("//button[normalize-space()='Accept']");
  session.click("//button[normalize-space()='Log in']");
})

/**
 *  The GoToShirts event defines the selenium actions for navigating to shirts page.
 */
defineEvent(SeleniumSession, "GoToShirts", function(session, e) {
  bp.log.info(e);
  session.click("//a[normalize-space()='Woman']"); //go to woman products
})

/**
 *  The GoToShirts event defines the selenium actions for navigating to shirts page.
 */
defineEvent(SeleniumSession, "FilterByAdidas", function(session, e) {
  bp.log.info(e);
  session.click("//input[@value='adidas']")
})