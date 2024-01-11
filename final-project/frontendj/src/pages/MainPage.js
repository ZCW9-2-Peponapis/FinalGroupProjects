import CreateDocumentIcon from "../components/CreateDocumentIcon";
import Library from "../components/Library";


function MainPage() {
    return (
        <div className="App">
            <header className="App-header">
                Welcome to Zip Docs
                <CreateDocumentIcon/>

                <Library/>


            </header>
        </div>

    );
}

export default MainPage;
