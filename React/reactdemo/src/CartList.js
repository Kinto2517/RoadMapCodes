import React, { Component } from "react";
import { Button, Table } from "reactstrap";

export default class CartList extends Component {
  renderCart() {
    return (
      <Table striped>
        <thead>
          <tr>
            <th>#</th>
            <th>Id</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Units In Stock</th>
            <th>Quantity</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {this.props.cart.map((product) => (
            <tr key={product.product.id}>
              <td>{product.product.id}</td>
              <td>{product.product.categoryId}</td>
              <td>{product.product.productName}</td>
              <td>{product.product.unitPrice}</td>
              <td>{product.product.unitsInStock}</td>
              <td>{product.quantity}</td>
              <td>
                <Button color="danger" onClick={()=>{
                    this.props.removeFromCart(product.product); 
                }}>Remove</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    );
  }

  render() {
    return <div>{this.renderCart()}</div>;
  }
}
