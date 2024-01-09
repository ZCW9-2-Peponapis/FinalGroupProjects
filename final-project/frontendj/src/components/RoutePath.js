import MainPage from "../pages/MainPage";
import NotFound from "../pages/NotFound";
import { BrowserRouter as Router, Link, Route, Routes } from 'react-router-dom';
import LoginPage from "../pages/LoginPage";
import RegisterPage from "../pages/RegisterPage";

export const  RoutePath =  () => {
    return (
        <Router>
            <nav>
                <ul>
                    <li>
                        <Link to="/home">Home</Link>
                    </li>
                    <li>
                        <Link to="/login">Login</Link>
                    </li>
                    <li>
                        <Link to="/register">Register</Link>
                    </li>
                    <li>
                        <Link to="/notfound">Not Found</Link>
                    </li>
                </ul>
            </nav>
            <Routes>
                <Route path="/home" component={MainPage} />
                <Route path="/login" component={LoginPage} />
                <Route path="/register" component={RegisterPage} />
                <Route path="/notfound" component={NotFound} />
            </Routes>
        </Router>
    )


}