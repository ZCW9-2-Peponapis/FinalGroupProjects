import React, { useState } from 'react';

const Login = () => {
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async () => {
        try {
            const response = await fetch('http://localhost:8080/users/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ userName, password }),
            });

            if (response.ok) {
                console.log('Login successful');
                // Redirect or show success message
            } else {
                console.error('Login failed');
                // Handle login failure
            }
        } catch (error) {
            console.error('Error during login:', error.message);
        }
    };

    return (
        <div>
            <h2>Login</h2>
            <label>Username:</label>
            <input type="text" value={userName} onChange={(e) => setUserName(e.target.value)} />
            <br />
            <label>Password:</label>
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
            <br />
            <button onClick={handleLogin}>Login</button>
        </div>
    );
};

export default Login;
