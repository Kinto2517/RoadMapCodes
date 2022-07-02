import React, { Component } from 'react'

export default class FormDemo1 extends Component {
    state = {userName: '' , userName2: ''}

    onSubmitHandler = (e) => {
        

        e.preventDefault();
    }

    onChangeHandler = (e)=>{
        // this.setState({userName: e.target.value})
        let name = e.target.name;
        let value = e.target.value;

        this.setState({[name]: value})
    }

    render() {
    return (
      <div>
        <form onSubmit={this.onSubmitHandler}>
            <label>User Name:</label>
            <input name="userName" type="text" value={this.state.userName} onChange={this.onChangeHandler
            }/>
            <label> UserName: {this.state.userName} </label>

            <label>User Name2:</label>
            <input name="userName2" type="text" value={this.state.userName2} onChange={this.onChangeHandler
            }/>
            <label> UserName: {this.state.userName2} </label>

            <button type="submit">Submit</button>
            

        </form>

      </div>
    )
  }
}
