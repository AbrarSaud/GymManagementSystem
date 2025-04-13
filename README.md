##  API Endpoints

 ### CRUD(create, read, update, and delete data.).
- **User:**
  - `GET     /api/v1/gym/users/get `                - Get all users
  - `POST    /api/v1/gym/users/add   `              - Add a new user  
  - `PUT     /api/v1/gym/users/update/{user_id}  `       - Update a user by ID  
  - `DELETE  /api/v1/gym/users/delete/{user_id}   `      - Delete a user by ID
- **Coach:**    
  - `GET     api/v1/gym/coach/get `             -Get all Coach  
  - `POST    api/v1/gym/coach/add `             - Create new Coach  
  - `PUT     api/v1/gym/coach/update/{post_id}`             - Update Coach by ID  
  - `DELETE  /api/v1/blog/posts/delete/{post_id}`             - Delete Coach by ID

- **GymClass:**
  - `GET     /api/v1/gym/gym-class/get `             -Get all GymClass  
  - `POST    /api/v1/gym/gym-class/add `             - Create new GymClass  
  - `PUT    /api/v1/gym/gym-class/update/{category_id}`             - Update GymClass by ID  
  - `DELETE  /api/v1/gym/gym-class/delete/{category_id}`             - Delete GymClass by ID
- **PersonalTrainin:**
   
  - `GET     /api/v1/gym/personal-training/get `             -Get all PersonalTrainin  
  - `POST    /api/v1/gym/personal-training/add `             - Create new PersonalTrainin  
  - `PUT     /api/v1/gym/personal-training/update/{comments_id}`             - Update PersonalTrainin by ID  
  - `DELETE  /api/v1/gym/personal-training/delete/{comments_id}`             - Delete PersonalTrainin by ID

- **Booking:**
   
  - `GET     /api/v1/gym/booking/get `             -Get all Booking  
  - `POST    /api/v1/gym/booking/add `             - Create new Booking  
  - `DELETE  /api/v1/gym/booking/delete/{comments_id}`             - Delete Booking by ID

 ### 15 Endpoints use JPA and JPQL 
| Entity  | #  | Endpoint                                                     | Description                                      |
|---------|----|---------------------------------------------------------------|--------------------------------------------------|
| Users    | 1  | `GET /api/v1/gym/users/high-bmi`                               | Show a list of users bmi >= 25                             |
| Users    | 2  | `GET /api/v1/gym/users/new`                                    | Show a list of New users                             |
| Coach    | 3  | `GET /api/v1/gym/coach/top-coaches`                    | Get best coaches                |
| Coach    | 4  | `PUT /api/v1/gym/coach/update-experience/{{coach_id}}/{{newYearsExperience}}`            | update Coach  Experience          |
| Coach | 5  | `POST api/v1/gym/coach/promote/{{userId}}`                       | promote User To Coach             |
| GymClass | 6  | `PUT /api/v1/gym/gym-class/update-capacity/{{gymClassId}}/{{newCapacity}}`              | update capacity         |
| GymClass    | 7  | `PUT /api/v1/gym/gym-class/update-class-name/{{classId}}?newName={{$newName}}`     |  update class name                      |
| GymClass    | 8  | `PUT /api/v1/gym/gym-class/update-room-number/{{classId}}?newRoomNumber={{$newRoomNumber}`          | Get users registered before a specific Date      |
| Personal-Training    | 9  | `GET /api/v1/gym/personal-training/subscription-info/{{personalTrainingId}}`          | Get Subscription Info      |
| Personal-Training    | 10  | `POST /api/v1/gym/personal-training/renew/{{pt_id}}/{{months}}`          | renew  Subscription     |
| Personal-Training     | 11  | `POST /api/v1/gym/personal-training/freeze/{{pt_id}}`          | freeze     |
| Personal-Training     | 12  | `PUT /api/v1/gym/personal-training/change-coach/{{ptId}}/{{oldCoachId}}/{{newCoachId}}`          | change Coach     |
| Personal-Training     | 13  | `PUT /api/v1/gym/personal-training/extend-freeze/{{pt_Id}}?extraDays={{$random.integer(100)}}`          | extend Freeze     |
| Booking     | 14  | `GET /api/v1/gym/booking/class/{{gymClassId}}`          | get Usernames In Class    |
| Booking     | 15 | `GET /api/v1/gym/booking/change/{{userId}}/{{oldGymClassId}}/{{newGymClassId}}`          | Change UserGym Class    |


##  Extra Endpoint
| Entity  | #  | Endpoint                                                     | Description                                      |
|---------|----|---------------------------------------------------------------|--------------------------------------------------|
| Booking    | 1  | `POST /api/v1/gym/booking/add`                               | Add new booking                           |
| Booking    | 3  | `DELETE  /api/v1/gym/booking/delete/{{booking_id}}`             | Delete Booking by ID                           |





    
