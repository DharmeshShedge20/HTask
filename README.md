# HTask

Here’s a more polished version of your project overview:

---

### Project Overview
This project is the backend for an online prescription platform, developed using Spring Boot and MongoDB. The platform facilitates consultations between doctors and patients. Patients can submit consultation forms, view doctor profiles, and manage their personal information. Doctors can register, sign in, and update their profiles.

### Technologies Used
- **Java 17**
- **Spring Boot**
- **MongoDB**
- **Spring Data MongoDB**
- **Lombok**

### Features

1. **Doctor Registration**: Doctors can register and sign in using their email and phone number.
2. **Patient Registration**: Patients can register and sign in using their email or phone number.
3. **Consultation Forms**: Patients can submit consultation forms that store their medical history, current illness details, and other relevant information.
4. **Doctor Profiles**: Doctors can view and update their profiles based on their name.

### API Endpoints

#### 1. Consultation Form Endpoints

- **POST /consultation**: Create a new consultation form.
  - **Request Body**:
    ```json
    {
      "currentIllnessHistory": "string",
      "recentSurgery": "string",
      "surgeryTimeSpan": "string",
      "isDiabetic": true,
      "allergies": "string",
      "otherFamilyConditions": "string"
    }
    ```
  - **Response**: `201 Created`
  
- **GET /consultation/{id}**: Retrieve a consultation form by ID.
  - **Response**:
    - `200 OK` (ConsultationForm)
    - `404 Not Found` (if the form does not exist)

- **GET /consultation**: Retrieve all consultation forms.
  - **Response**: `200 OK` (List of ConsultationForms)

#### 2. Doctor Endpoints

- **POST /api/doctor/signup**: Register a new doctor.
  - **Request Body**:
    ```json
    {
      "profilePicture": "string",
      "name": "string",
      "specialty": "string",
      "email": "string",
      "phoneNumber": "string",
      "experience": 5
    }
    ```
  - **Response**: `200 OK` (Doctor)
  
- **POST /api/doctor/signin**: Doctor sign-in using email and phone number.
  - **Request Body**:
    ```json
    {
      "email": "string",
      "phoneNumber": "string"
    }
    ```
  - **Response**:
    - `200 OK` (Doctor)
    - `401 Unauthorized` (if credentials are invalid)

- **GET /api/doctor/{name}/profile**: Retrieve doctor profile by name.
  - **Response**:
    - `200 OK` (Doctor Profile)
    - `404 Not Found` (if doctor not found)

#### 3. Patient Endpoints

- **POST /api/patient/signup**: Register a new patient.
  - **Request Body**:
    ```json
    {
      "profilePicture": "string",
      "name": "string",
      "age": 30,
      "email": "string",
      "phoneNumber": "string"
    }
    ```
  - **Response**: `200 OK` (Patient)

- **POST /api/patient/signin**: Patient sign-in using email or phone number.
  - **Request Parameters**: 
    - `email` (optional)
    - `phoneNumber` (optional)
  - **Response**: `200 OK` (Patient)

- **GET /api/patient/doctors**: Get a list of doctor names.
  - **Response**: `200 OK` (List of Doctor Names)

### Project Setup Requirements

- **Java 17**
- **Spring Boot**
- **MongoDB**
- **Maven**

---

This version organizes the content clearly and ensures a professional tone while maintaining the technical details.
