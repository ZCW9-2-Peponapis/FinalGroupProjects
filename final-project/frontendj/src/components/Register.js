import React, { useState, useEffect } from 'react';
import './Register.css';

const Register = () => {
    const [name, setName] = useState('');
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [registrationSuccess, setRegistrationSuccess] = useState(false);

    useEffect(() => {
        // Check user login status here (use your authentication logic)
        const userLoggedIn = localStorage.getItem('userInfo') !== null;
        setIsLoggedIn(userLoggedIn);
    }, []);

    const handleRegister = async () => {
        // Check user login status again to prevent registration if the user logs in during the registration process
        const userLoggedIn = localStorage.getItem('userInfo') !== null;
        if (userLoggedIn) {
            alert('User is already logged in. Registration not allowed.');
            //
            return;
        }

        try {
            // Your registration logic here
            console.log('Registration success');

            setRegistrationSuccess(true);
        } catch (error) {
            console.error('Error during registration:', error.message);
        }
    };

    if (isLoggedIn) {
        return <p>User is already logged in. Please log out current account before registering.</p>;
    }

    return (
        <div>
            <h2>Register</h2>
            {registrationSuccess ? (
                <p>Registration successful! You can now log in.</p>
            ) : (
                <>
                    <label>Name:</label>
                    <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
                    <br />
                    <label>Username:</label>
                    <input type="text" value={userName} onChange={(e) => setUserName(e.target.value)} />
                    <br />
                    <label>Password:</label>
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                    <br />
                    <button onClick={handleRegister}>Register</button>
                </>
            )}
        </div>
    );
};

export default Register;
