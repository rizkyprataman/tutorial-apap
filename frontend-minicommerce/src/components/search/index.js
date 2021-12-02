import React from "react";

const Search = (props) => {
    const { action, submit, itemSearch} = props;
    return (
      <form>
        <input type="text" name="itemSearch" value={itemSearch} onChange={action}/>
        <input type="submit" onClick={submit} hidden />
      </form>
    );
  };
  
  export default Search;