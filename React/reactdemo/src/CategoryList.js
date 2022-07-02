import React, { Component } from "react";
import { ListGroup, ListGroupItem } from "reactstrap";

export default class CategoryList extends Component {

  render() {
    return (
      <div>
        <h3>{this.props.info.title} </h3>

        <ListGroup>
          {this.props.categories.map((category) => (
            <ListGroupItem
                active={this.props.currentCategory === category.categoryName}
              key={category.id}
              onClick={() => this.props.changeCategory(category)}
            >
              {category.categoryName}
            </ListGroupItem>
          ))}
        </ListGroup>

        {/* <h4>{this.props.currentCategory}</h4> */}
      </div>
    );
  }
}
