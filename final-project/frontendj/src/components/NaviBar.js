import './NaviBar.css'
function NaviBar() {

    return(
        <div className="navbar">
            <a href="/">Home</a>
            <a href="/register">Register</a>
            <div className="dropdown">
                <button className="dropbtn">Info
                    <i className="fa fa-caret-down"></i>
                </button>
                <div className="dropdown-content">
                    <a href="#">About Us</a>
                    <a href="https://github.com/ZCW9-2-Peponapis/FinalGroupProjects">GitHub Link</a>
                </div>
            </div>
        </div>
    );
}

export default NaviBar;