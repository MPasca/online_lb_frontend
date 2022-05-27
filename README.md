# online_lb_frontend

This is the last half of the Online Library project.

Whilst I worked on the backend, I need a way for users to access it, hence the front end.

Now, the project is taking the shape of a mobile application written in Kotlin for Android Devices.

The mobile application has a login form alongside a sign up form (coming soon).

After the user is registered, the user can use ha bottom navigation toolbar to navigate between their profile, browsing books and checking their history of borrowed books.

When checking their profile, the user can decide to update their personal information by clicking the edit profile button. After they're done, they can click on the update button to send the new info to the program or revert to cancel the update (coming soon).

Borrowed books & Browse books - same idea, take the rows from the DB - implement search option to find a title (coming soon).


TO DO:
login & sign up
revert changes button for profile
get books from DB and send them to the app
logout

update May 26th 2022, 10:37 pm
I tried to implement both the personal data information update in ProfileFragment
    & the fetchBooks method that fetches the book list from the DB through the backend's end points
    but for some god forsaken reason these stuff won't work and I'm pissed, and tired, my head is hurting and IMMA THROW HANDS I SWEAR TO GOD
ok that's all for now, byeee


update May 27th 2022, 8:08 pm
I reiterated last night's problems, but to no avail. Apparently there's some kind of socket error.
Rewritten the classes (all of them) in kotlin


So far, what the app does (or tries to do):
The application has three fragments that represent the activities of the application.
1st one: Profile
    fetches the information of the current reader and prints it on the screen, so that the current user can see it
    can update the information of the current reader

2nd one: Books
    can browse through the books currently found in the library

3rd one: Borrowings
    same with books, a reader should be able to browse through it's history of borrowed books.
