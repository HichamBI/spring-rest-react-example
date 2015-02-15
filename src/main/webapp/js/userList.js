var User = React.createClass({
    render: function () {
        return (
            <div className="user">
                <div>Hello {this.props.name} ! Your id is {this.props.id}</div>
            </div>
            );
    }
});

var UserList = React.createClass({
    getInitialState: function () {
        return {data: []};
    },

    componentDidMount: function () {
        $.ajax({
            url: "http://localhost:8080/user/all",
            dataType: 'json',
            success: function (data) {
                this.setState({data: data});
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    },

    render: function () {
        var userNodes = this.state.data.map(function (user) {
            return (
                <User name={user.name} id={user.id}></User>
                );
        });
        return (
            <div className="userList">
                {userNodes}
            </div>
            );
    }
});

React.render(
    <UserList/>,
    document.getElementById('content')
);