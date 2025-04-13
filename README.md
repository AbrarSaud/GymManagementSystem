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

### 15 Endpoints use JPA and JPQL

| #  | Entity           | Endpoint | Description |
|----|------------------|----------|-------------|
| 1  | Users            | `GET /api/v1/gym/users/high-bmi` | Get all users where BMI is greater than or equal to 25. |
| 2  | Users            | `GET /api/v1/gym/users/new` | Get users registered within the last 7 days. |
| 3  | Users            | `PUT /api/v1/gym/users/calculate-bmi/{user_id}` | Calculate BMI using weight and height, and update user's BMI and category. |
| 4  | Coach            | `GET /api/v1/gym/coach/top-coaches` | Get all coaches ordered by years of experience (best coaches first). |
| 5  | Coach            | `PUT /api/v1/gym/coach/update-experience/{coach_id}/{newYearsExperience}` | Update a coach's years of experience if the new experience value is higher. |
| 6  | Coach            | `POST /api/v1/gym/coach/promote/{userId}` | Promote a user to coach by saving new coach info and deleting user account. |
| 7  | GymClass         | `PUT /api/v1/gym/gym-class/update-capacity/{gymClassId}/{newCapacity}` | Update gym class capacity if new capacity is different from the current one. |
| 8  | GymClass         | `PUT /api/v1/gym/gym-class/update-class-name/{classId}` | Update the name of a gym class. |
| 9  | GymClass         | `PUT /api/v1/gym/gym-class/update-room-number/{classId}` | Update the room number assigned to a gym class. |
| 10 | Personal-Training| `GET /api/v1/gym/personal-training/subscription-info/{personalTrainingId}` | Get subscription information by personal training ID if it exists. |
| 11 | Personal-Training| `POST /api/v1/gym/personal-training/renew/{pt_id}/{months}` | Renew a subscription by adding the specified number of months. |
| 12 | Personal-Training| `POST /api/v1/gym/personal-training/discount/{pt_id}` | Apply a discount to a subscription and update the subscription price. |
| 13 | Personal-Training| `PUT /api/v1/gym/personal-training/freeze/{pt_id}` | Freeze an active subscription using the personal training ID. |
| 14 | Personal-Training| `PUT /api/v1/gym/personal-training/change-coach/{pt_id}/{newCoachId}` | Change the coach assigned to a subscription by updating to a new coach ID. |
| 15 | Personal-Training| `PUT /api/v1/gym/personal-training/extend-freeze/{pt_id}` | Extend the freeze period by adding extra freeze days to the subscription. |



## Extra Endpoint

| #  | Entity  | Endpoint | Description |
|----|---------|----------|-------------|
| 16 | Booking | `POST /api/v1/gym/booking/add` | Add a booking if user and gym class exist, and capacity > 0. Decrease capacity by 1 and save booking. |
| 17 | Booking | `DELETE /api/v1/gym/booking/delete/{booking_id}` | Delete a booking if it exists, and increase gym class capacity by 1. |
| 18 | Booking | `GET /api/v1/gym/booking/class/{gymClassId}` | Show all usernames registered in a specific gym class. |
| 19 | Booking | `PUT /api/v1/gym/booking/change/{userId}/{oldGymClassId}/{newGymClassId}` | Change a user's gym class by moving them from the old class to the new one. |





    
