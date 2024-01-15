import './NaviBar.css'
import {useEffect, useState} from "react";
function NaviBar() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    useEffect(() => {
        // Check user login status here, login and register does not appear
        const userLoggedIn = localStorage.getItem('userInfo') !== null;
        setIsLoggedIn(userLoggedIn);
    }, []);


    return(
        <div className="navbar">
            <a href="/">Home</a>
            {isLoggedIn ? false : <a href="/login">Login</a>}
            {isLoggedIn ? false : <a href="/register">Register</a>}
            <div className="dropdown">
                <button className="dropbtn">Info
                    <i className="fa fa-caret-down"></i>
                </button>
                <div className="dropdown-content">
                    <a href="/about">About Us</a>
                    <a href="https://github.com/ZCW9-2-Peponapis/FinalGroupProjects">GitHub Link</a>
                </div>
            </div>
        </div>
    );
}

export default NaviBar;