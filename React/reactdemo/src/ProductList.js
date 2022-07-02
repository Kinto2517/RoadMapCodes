import React, { Component } from 'react'
import { Button } from 'reactstrap'

export default class ProductList extends Component {

  

  render() {
    return (
      <div>
        
        <h3>{ this.props.info.title}</h3>


        <table class="table">
  <thead>
    <tr>
      <th scope="col">Category Id</th>
      <th scope="col">Product Name</th>
      <th scope="col">Quantity Per Unit</th>
      <th scope="col">Unit Price</th>
      <th scope="col">Units In Stock</th>
      <th>Add To Cart</th>
    </tr>
  </thead>

  <tbody>
  {this.props.products.map((product) => (
            <tr key={product.id}>
             
                <td>{product.categoryId}</td>
                <td>{product.productName}</td>
                <td>{product.quantityPerUnit}</td>
                <td>{product.unitPrice}</td>
                <td>{product.unitsInStock}</td>
                <td><Button onClick={()=> this.props.addToCart(product)}  color="info">Clicky!</Button></td>
             
            </tr>
          ))

        }
  </tbody>
</table>


      </div>
    )
  }
}
