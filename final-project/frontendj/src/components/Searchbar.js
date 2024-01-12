import "./Searchbar.css";
import SearchIcon from '@mui/icons-material/Search';


function SearchBar({placeholder, dataResult}) {
        return(
        <div className="parent-container">
        <div className="search">
        <div className="searchInputs">
        <input  type="text" placeholder={placeholder} />
        <div className="searchIcon">
        <SearchIcon/>
        </div>
        </div>
        <div className="dataResult"></div>
        </div>
        </div>

        );
}
export default SearchBar