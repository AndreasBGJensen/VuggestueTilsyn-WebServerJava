import React from 'react'


class UserForm extends React.Component {
    state= {
        firstName: '',
        lastName: '',
        email: '',
    }


    //Handle field change
    //"e" is the event parameter
    handleChange = input => e => {
        this.setState({[input]: e.target.value})
    }

    render() {
        const {firstName , email, lastName} = this.state;
        const values = {firstName, lastName, email};
        return (
            <div>
                <h1>Venligst indsæt dit navn, efternavn og email</h1>
            </div>
        )
    }
}

export default UserForm;