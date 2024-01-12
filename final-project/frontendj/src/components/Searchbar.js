import "./Searchbar.css";



function SearchBar({placeholder, dataResult}) {
        return(
        <div className="search">
        <div className="searchInputs">
        <input  type="text" placeholder={placeholder} />
        <div className="searchIcon"></div>
        </div>
        <div className="dataResult"></div>
        </div>

        );
}
export default SearchBar