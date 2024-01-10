// RoutePath.jsx

import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import MainPage from "../pages/MainPage";
import LoginPage from "../pages/LoginPage";
import RegisterPage from "../pages/RegisterPage";
import EditorPage from "../pages/EditorPage";
import './MenuBar.css';
import Logout from "./Logout"; // Import the styles

const UserMenu = () => {
    return (
        <div className="user-menu">
            {/* Add user-related menu items or components here */}
            <Link to="/profile" className="menu-item">Profile</Link>
            <Link to="/register" className="menu-item">Register</Link>
        </div>
    );
};

const MenuBar = () => {
    return (
        <div className="menu-bar">
            <div className="menu-items">
                <Link to="/edit" className="menu-item">Edit</Link>
            </div>
            <UserMenu /> {/* Render the UserMenu component */}
        </div>
    );
};

const RoutePath = () => {
    return (
        <Router>
            <div>
                <MenuBar />

                <Routes>
                    <Route path="/" element={<MainPage />} />
                    <Route path="/edit" element={<EditorPage />} />
                    <Route path="/register" element={<RegisterPage />} />
                    <Route path="login" element={<LoginPage />} />
                    <Route path="/logout" element={<Logout/>} />
                </Routes>
            </div>
        </Router>
    );
};

export default RoutePath;
