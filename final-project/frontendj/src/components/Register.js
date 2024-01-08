import React, { useState } from 'react';

const Register = () => {
    const [name, setName] = useState('');
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');

    const handleRegister = async () => {
        try {
            const response = await fetch('http://localhost:8080/users/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ name, userName, password }),
            });

            if (response.ok) {
                console.log('Registration successful');
                // Redirect or show success message
            } else {
                console.error('Registration failed');
                // Handle registration failure
            }
        } catch (error) {
            console.error('Error during registration:', error.message);
        }
    };

    return (
        <div>
            <h2>Register</h2>
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
        </div>
    );
};

export default Register;
