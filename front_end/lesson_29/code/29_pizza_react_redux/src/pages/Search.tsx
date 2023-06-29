import React, {useEffect} from "react";
import { useSelector, useDispatch } from "react-redux";
import { selectFilter } from "../redux/slices/filterSlice";
import { selectSearch } from "../redux/slices/searchSlice";
import { selectItemsData } from "../redux/slices/itemsSlice";
import Cards from "../components/Cards";

const Search: React.FC = () => {
    const { categoryId, sortingItem } = useSelector(selectFilter);
    const { searchValue } = useSelector(selectSearch);
    const { items } = useSelector(selectItemsData);
    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(
            // @ts-ignore
            fetchItems({
                categoryId,
                sortingItem,
                searchValue
            })
        )
    }, [categoryId, sortingItem, searchValue])

    return (
        <div>
            <Cards
                title={
                    items.length > 0
                    ? `Результат поиска: ${searchValue}`
                    : `По запросу ${searchValue} ничего не найдено`
                }
            />        
        </div>
    );
};

export default Search;
