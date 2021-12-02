import React from "react";
import Button from "../button";
import classes from "./styles.module.css";
const Item = (props) => {
    const { id, title, price, description, category, quantity, handleEdit, handleDelete, cartQuantity, handleAddCart , action} = props;
    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`stok: ${quantity}`}</p>
            <Button action={handleEdit}>
                Edit
            </Button>
            <form>
            <input type="number" name="cartQuantity" value={cartQuantity} onChange={action} />
            <Button type="submit" action={handleAddCart}>Add Cart</Button>
            </form>
            
        </div>
    );
};
export default Item;