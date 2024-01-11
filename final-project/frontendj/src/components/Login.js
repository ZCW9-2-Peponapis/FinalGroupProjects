// Login.js (LoginMenu component)

import React, { useState } from 'react';

const Login = ({ onLogin }) => {
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');

    const refreshPage = () => {
        window.location.reload();
    }

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
                const userData = await response.json();

                // Save user session in localStorage
                localStorage.setItem('userName', JSON.stringify(userData.userName));
                localStorage.setItem('userInfo', JSON.stringify(userData));

                // Notify the parent component about the login
                onLogin();



                console.log(localStorage.getItem('userInfo'));


                // Redirect or show success message
                console.log('Login successful');
                {refreshPage()}
            } else {
                console.error('Login failed');
                // Handle login failure
            }
        } catch (error) {
            console.error('Error during login:', error.message);
        }
    };

    return (
        <div className="login-menu">
            <input
                type="text"
                placeholder="Username"
                value={userName}
                onChange={(e) => setUserName(e.target.value)}
                style={{display: 'block', marginBottom: '10px'}}
            />
            <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                style={{display: 'block', marginBottom: '10px'}}
            />
            <button onClick={handleLogin}>Login</button>
        </div>

    );
};

export default Login;
