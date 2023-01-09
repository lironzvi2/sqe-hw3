/* @provengo summon selenium */

const OLD_DESCRIPTION = 'Old Quiz Description';
const NEW_DESCRIPTION = 'New Quiz Description'
story('change quiz description', function () {
  let s = new SeleniumSession().start('http://127.0.0.1/login')
  s.login({username: 'teacher', password: 'teacher'})
  s.changeQuizDescription({ id: 1234, newDescription: NEW_DESCRIPTION })
})

story('attempt quiz', function () {
  let s = new SeleniumSession().start('http://127.0.0.1/login')
  s.login({username: 'student', password: 'student'})
  s.attemptQuiz({ id: 1234 })
})