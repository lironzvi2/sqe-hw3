/* @provengo summon selenium */

/**
 * This story opens a new browser window, goes to google.com, and searches for a pizza.
 */
story('Delete Adidas Shirt', function () {
  let s = new SeleniumSession().start('https://ci.simplcommerce.com/login')
  s.loginAdmin({username: 'admin@simplcommerce.com', password: '1qazZAQ!'})
  s.findAdidasShirtAndDelete()
})

/**
 * This story opens a new browser window, goes to google.com, and searches for a pizza using the "I Feel Lucky" feature.
 */
story('filter by adidas', function () {
  // the "with" statement makes it redundant to write "s." before each call to a defined event (like the story above)
  with (new SeleniumSession().start('https://ci.simplcommerce.com/login')) {
    loginUser({username: 'CustomerlironAndOfir@test.com', password: 'LironOfir123!'})
    goToShirts()
    filterByAdidas()
  }
})