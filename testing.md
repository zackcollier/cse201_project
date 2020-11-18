# Table of Contents
- Unit Tests
- Integration Tests
- System Tests
- Black Box Tests
- Gray Box Tests
- White Box Tests

## Unit Tests
| File      | Test | Passing? |
| --------- | -------- | --- |
| AdminTest | testApproveRequest | [x] |
| ApplicationTest | testCommentSystem | [x] |
| ApplicationTest | testCalcAvgRating | [x] |
| DeveloperTest | testUpdateApp | [x] |
| DeveloperTest | testSubmitRequest | [x] |
| ModeratorTest | testRemoveComments | [x] |
| UserTest | testSignUp | [x] |
| UserTest | testLogin | [x] |
| UserTest | testLogout | [x] |
| UserTest | testComment | [x] |
| UserTest | testSearch | [x] |
| UserTest | testSort | [x] |

\* These tests are not yet implemented

## Integration Tests
1. Upload and Update App [ ]
- A developer submits and app
- An admin approves the developer's submit request
- The developer updates the app
2. Comment and Rate [ ]
- A user comments on an app
- The user rates an app
- The user can see the comment and the rating of the app changes

## System Tests
1. User Case [ ]
- Create an account
- Login
- Search and sort for an app
- Rate an app
2. Developer Case [ ]
- Login
- Submit app
- Update app once app is approved
3. Moderator Case [ ]
- Login 
- Filter apps
- remove comments on an app
4. Admin Case [ ]
- Login
- Approve App
- Find approved app
- Comment on the approved app

## Black Box Tests
- Can a user create an account and then login later? [x]
- Can a developer submit a new app and see it on the application once approved? [ ]
- Can a user both leave and read comments on applications? [x]
- Can users input text without there being formatting issues? (What happens if there is a \\n?) [x]

## Grey Box Tests
- Do files get updated when an applciation is accepted? [ ]
- Can only admins see unapproved applications? [ ]
- Does an app update change the proper files? [ ]

## White Box Tests
- Are negative rating handeled? [x]
- Are empty app submissions rejected? [ ]
- Can a user rate an app only a single time? [ ]
