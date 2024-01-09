import TextEditor from "../components/TextEditor";
import LoginButton from "../components/LoginButton";
import RegisterButton from "../components/RegisterButton";

function FrontPage() {
    return (
        <div className="App">
            <header className="App-header">
                <a
                    className="App-link"
                    href="https://github.com/ZCW9-2-Peponapis/FinalGroupProjects"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Zip Docs
                </a>
                <TextEditor/>
                <LoginButton/>
                <RegisterButton/>


            </header>
        </div>

    );
}

export default FrontPage;
