
import add from '../add.png';
import './CreateDocumentIcon.css';
import {Link} from "react-router-dom";

const CreateDocumentIcon = () => {

    const isLoggedIn = () => {
        return localStorage.getItem('userInfo') !== null;
    }

    const refreshPage = () => {
        window.location.reload(); // Maybe used later
    }



    const handleClick = async () => {
        if (isLoggedIn()){
            console.log("You can create!")
        } else {
            console.log("You cannot create!")
        }
    };

    return (
        <div>
            {isLoggedIn() ? (
            <Link to="/edit" className="createDocumentIcon">
                <img className="image"
                    src={add}
                    alt="Create Document"
                    onClick={handleClick}
                    style={{cursor:'pointer'}}
                />
            </Link>
                ) : (

                        <img
                            src={add}
                            alt="Create Document"
                            className="image"
                        />

                )}
        </div>
    );
};

export default CreateDocumentIcon;